package com.me.jdk.collection.concurrent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 在Java中有两类线程：用户线程 (User Thread)、守护线程 (Daemon Thread)。 
 * 所谓守护 线程，是指在程序运行的时候在后台提供一种通用服务的线程，比如垃圾回收线程就是一个很称职的守护者，并且这种线程并不属于程序中不可或缺的部分。因此，当所有的非守护线程结束时，程序也就终止了，同时会杀死进程中的所有守护线程。反过来说，
 * 只要任何非守护线程还在运行，程序就不会终止。
 * 用户线程和守护线程两者几乎没有区别，唯一的不同之处就在于虚拟机的离开：如果用户线程已经全部退出运行了，只剩下守护线程存在了，虚拟机也就退出了。 因为没有了被守护者，守护线程也就没有工作可做了，也就没有继续运行程序的必要了。
 * 将线程转换为守护线程可以通过调用Thread对象的setDaemon(true)方法来实现。在使用守护线程时需要注意一下几点：
 *
 */
public class SendMailBackGroudExecutor {
	
	public static BlockingQueue<String> emailQueue = new LinkedBlockingQueue<String>();
	public static void main(String[] args) {
		final SendMailBackGroudExecutor executor = new SendMailBackGroudExecutor();
		
		Runnable worker = new Runnable() {
			public void run() {
				for (int i = 1; i<= 1000; i++) {
					executor.sendMail("mail message " + i);
				}
				
			}
		};
		Thread t = new Thread(worker);
		Thread t1 = new Thread(worker);
		Thread t2 = new Thread(worker);
		t.start();
		t1.start();
		t2.start();
		
		
		//如果用户进程停止了，守护进程也就停止了		
		while(emailQueue.size() >0) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private static ExecutorService sendEmailExecutorService;
	
	static {
		initializeSendMailBackGroudExecutor();
	}

	public ExecutorService getSendEmailExecutorService() {
		return sendEmailExecutorService;
	}

	/**
	 * Generate email body with Velocity template with the model
	 * 
	 * Send Email,
	 * 
	 * @param model
	 * @throws Exception
	 */
	public void sendMail(String mailMessage) {

		if (sendEmailExecutorService == null) {
			initializeSendMailBackGroudExecutor();
		}

		try {
			emailQueue.put(mailMessage);
			System.out.println("put mail: " + mailMessage + " queue, there are " + emailQueue.size() +  " email. ");
		} catch (Exception e) {
			String errLogMsg = "Exception with push mail in blocking queue : "
					+ mailMessage;
			System.err.println(errLogMsg);
		}

	}

	public static void initializeSendMailBackGroudExecutor() {
		synchronized (SendMailBackGroudExecutor.class) {
			sendEmailExecutorService = Executors.newFixedThreadPool(3,
					new EmailSendThreadFactory());
			sendEmailExecutorService
					.execute(new EmailSenderConsumer(emailQueue));
			sendEmailExecutorService
			.execute(new EmailSenderConsumer(emailQueue));
			
			sendEmailExecutorService
			.execute(new EmailSenderConsumer(emailQueue));
		}
	}

	static class EmailSenderConsumer implements Runnable {
		
	
		private final BlockingQueue<String> emailQueue;

		EmailSenderConsumer(BlockingQueue<String> q) {
			this.emailQueue = q;
		}

		public void run() {
			Thread.currentThread().setUncaughtExceptionHandler(
					new SendEmailJobUncaughtExceptionHandler());

			while (true) {
				try {
					consume(emailQueue.take());
					Thread.sleep(100);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		private void consume(String email) {
			System.err.println(Thread.currentThread().getName() + "  Sending " + email +  "........" + " queue size: " +  emailQueue.size());
		}

	}

	static class EmailSendThreadFactory implements ThreadFactory {
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		}
	}

	static class SendEmailJobUncaughtExceptionHandler implements
			UncaughtExceptionHandler {

		public SendEmailJobUncaughtExceptionHandler() {
			super();
		}

		public void uncaughtException(Thread t, Throwable e) {

			// 1 log uncaught exception
			long threadId = t.getId();
			String errMsg = "The current thread information: [thread ID-"
					+ threadId + ", thread state - " + t.getState()
					+ ", uncaught exception class- " + ""
					+ e.getClass().getName() + "]";
			System.out.println(errMsg);

			// check it into Catalina.out
			e.printStackTrace();

			PrintWriter pw = null;
			try {
				Date date = Calendar.getInstance().getTime();
				String threadDumpFileName = System.getProperty("user.dir")
						+ "/thread_dump/mailSender-"
						+ DateFormatUtils.format(date, "yyyy-MM-ddHH:mm:ss");
				File file = new File(threadDumpFileName);
				if (file.exists() == false) {
					file.createNewFile();
				}
				pw = new PrintWriter(file);
				e.printStackTrace(new PrintWriter(pw));
				pw.flush();
			} catch (FileNotFoundException e3) {
				e3.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				if (pw != null) {
					pw.close();
				}
			}

			try {
				if (sendEmailExecutorService == null) {
					initializeSendMailBackGroudExecutor();
				}
				sendEmailExecutorService.execute(new EmailSenderConsumer(
						emailQueue));
			} catch (RejectedExecutionException e2) {
				e2.printStackTrace();
			}
		}
	}
}
