package com.me.jvm.oom;

import java.util.HashMap;
import java.util.Map;

import com.me.jvm.system.SystemInfo;

public class MemoryLeakDemo {
	static class Key {
		Integer id;

		public Key(Integer id) {
			super();
			this.id = id;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
			
	}
	public static void main(String[] args) {
		SystemInfo.displayJvmMemoryInfo();
		Map<Key, String> m = new HashMap<Key, String>();
		while (true) {
			for (int i = 0; i<= 100000000000L; i++) {
				m.put(new Key(i), "Number" + i);
			}
		}
	}

}
