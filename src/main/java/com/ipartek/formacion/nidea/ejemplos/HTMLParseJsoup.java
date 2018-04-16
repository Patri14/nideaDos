package com.ipartek.formacion.nidea.ejemplos;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLParseJsoup {

	public static void main(String[] args) throws IOException {

		String url = "http://localhost:8080/nidea/login";

		Connection.Response response = Jsoup.connect(url).method(Connection.Method.POST).data("usuario", "admin")
				.data("password", "admin").execute();

		Document doc = response.parse();
		System.out.println(doc.getElementsByTag("h1").get(0).text());

	}

}
