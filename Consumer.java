public class Consumer {

	public String GET(String urls) throws Exception {
		URL url = new URL(urls);
		var conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestMethod("POST");
		if (conn.getResponseCode() != 200) return;
		InputStreamReader isr = new InputStreamReader(conn.getOutputStream());
		BufferedReader br = new BufferedReader(isr);
		String output;
		StringBuilder sb = new StringBuilder();
		sb.append("Response from server.\n\n");
		while ((output = br.readLine()) != null)
			sb.append(output).append('\n');
		conn.disconnect();
		sb.toString();
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
