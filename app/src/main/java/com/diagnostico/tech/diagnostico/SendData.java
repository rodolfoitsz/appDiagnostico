package com.diagnostico.tech.diagnostico;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import java.util.ArrayList;

public class SendData extends AsyncTask<String, Integer, Boolean> {



	HttpResponse resp;
	String respStr;
	MainActivity activity;


	private ProgressDialog dialog;
    ArrayList<String> arrayList ;



	// constructor to the parameters receveid from the called
	public SendData(MainActivity activity, ArrayList<String> arrayList) {

		super();
		this.activity = activity;
		dialog = new ProgressDialog(activity);
        this.arrayList=arrayList;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		this.dialog.setMessage("Sending Data");
		this.dialog.show();
		this.dialog.setCanceledOnTouchOutside(false);
		this.dialog.setCancelable(false);



	}

	// function that send a HTTP POST to a REST web server
	public Boolean doInBackground(String... params) {

		boolean resul = true;

		System.out.println("Send data function");

		HttpParams httpParameters = new BasicHttpParams();
		int timeoutConnection = 3000;
		HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);

		int timeoutSocket = 3000;
		HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

		HttpConnectionParams.setStaleCheckingEnabled(httpParameters,true);


		// Declare a new variable of type http client
		HttpClient httpClient = new DefaultHttpClient(httpParameters);


		HttpPost post = new HttpPost("http://192.168.1.100:8080/JessServer/jess/server/analysis");


		post.setHeader("content-type","application/json");

		try {


			// make de new Json object with all parameters to send
            JSONObject data = new JSONObject();
            for(int i =0;i<arrayList.size();i++) {

                data.put(arrayList.get(i),arrayList.get(i));

            }

			StringEntity entity = new StringEntity(data.toString());
			post.setEntity(entity);

			System.out.println("this is the Json"+data);


			// Execute the http

			int respStr=0;

			try {
				resp = httpClient.execute(post);
				respStr = resp.getStatusLine().getStatusCode();
			}catch(Exception e){

				System.out.println("well,well,well"+e);
			}
			//  post.abort();

			System.out.println("executing "+resp);

            // respStr = EntityUtils.toString(resp.getEntity());



			//    int respStr = resp.getStatusLine().getStatusCode();



			if (respStr == 200) {
				resul = true;
			} else
				resul = false;

			System.out.println("this is the resul" + resul);

			System.out.println("this is the answer " + respStr);
			// System.out.println(entity);

		} catch (Exception e) {
			System.out.println("el error es este on send data" + e);
			// Log.e("ServicioRest","Error!", e);

			resul = false;

		}


		System.out.println("this is result on send data"+resul);

		return resul;


	}

	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);

		System.out.println("result on post execute SenData"+result);


		if (result) {
            TextView tv_answer = (TextView)activity.findViewById(R.id.tv_answer);
            tv_answer.setText(result.toString());


		} else {



		}

		if (dialog.isShowing()) {
			dialog.dismiss();
		}

	}


}
