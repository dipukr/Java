public class Consumer {

	public String GET(String urls) throws Exception {
		URL url = new URL(urls);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("Cookie", "ccc");
		connection.setRequestMethod("GET");
		connection.setDoInput(true);
		if (connection.getResponseCode() != 200) return;
		InputStream inputStream = connection.getInputStream();
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(isr);
		StringBuilder data = new StringBuilder();
		while (true) {
			String line = reader.readLine();
			if (Objects.isNull(line)) break;
			data.append(line).append('\n');
		}
		connection.disconnect();
		JSONObject json = new JSONObject(String.valueOf(data));
		return json.toString(4);
	}

	public String POST(String urls) throws Exception {
		String json = "{'name': 'DipuKumar', 'age': 25}";
		URL url = new URL(urls);
		var conn = (HttpURLConnection) url.openConnection();
		conn.setConnectionTimeout(5000);
		conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		OutputStream ostream = conn.getOutputStream();
		ostream.write(json.getBytes("UTF-8"));
		ostream.close();
		InputStream istream = new BufferedInputStream(conn.getInputStream());
		String result = IOUtils.toString(in, "UTF-8");
		JSONObject jsonObject = new JSONObject(result);
		in.close();
		conn.disconnect();
		return String.format("JSON Response: %s\n\n", result) + result;
	}

	public static void main(String[] args) throws Exception {
		String url = "www.dummy.restapiexample.com/api/v1/employess";
		String response = GET(url);
		System.out.println(response);
	}
}
