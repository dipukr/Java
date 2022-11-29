public class Dictionary {

	private final Map<String, String> m = new TreeMap<String, String>();
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock r = lock.readLock();
	private final Lock w = lock.writeLock();

	public String get(String key) {
		r.lock();
		try {
			return m.get(key);
		} finally {
			r.unlock();
		}
	}

	public List<String> allKeys() {
		r.lock();
		try {
			return new ArrayList<String>(m.keySet());
		} finally {
			r.unlock();
		}
	}
	
	public String put(String key, String value) {
		w.lock();
		try {
			return m.put(key, value);
		} finally {
			w.unlock();
		}
	}

	public void clear() {
		w.lock();
		try {
			m.clear();
		} finally {
			w.unlock();
		}
	}
}