package br.com.brazuca.brazucaapi.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ScrapingUtil {


	public static void main(String[] args) throws IOException {
	}
		

	public static String requestDoadores() throws IOException {

		URL url = new URL("https://s3.amazonaws.com/gupy5/production/companies/52441/emails/1669646172212/e8330670-6f23-11ed-91a8-05f5cf6759fb/data_1.json");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");

		InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";
		System.out.println(response);
		
		
		return response;
	}



}

/*
 * PartidaUolDTO partidaUolDto = new PartidaUolDTO();
 * partidaUolDto.setCompeticao(jsonNode.get("competicao").toString());
 * partidaUolDto.setIdCompeticao(jsonNode.get("id-competicao").toString());
 * partidaUolDto.setFase(jsonNode.get("fase").toString());
 * partidaUolDto.setPosicao(jsonNode.get("posicao").toString());
 * partidaUolDto.setRodada(jsonNode.get("rodada").toString());
 * partidaUolDto.setData(jsonNode.get("data").toString());
 * partidaUolDto.setHorario(jsonNode.get("horario").toString());
 * 
 * // for (int i=0; i< jsonNode.get("time1").size(); i++) {
 * 
 * Equipe equipeCasa = new Equipe();
 * equipeCasa.setId(Long.parseLong(jsonNode.get("time1").findPath("id").toString
 * ()));
 * equipeCasa.setNomeEquipe(jsonNode.get("time1").findPath("nome-completo").
 * toString());
 * equipeCasa.setNomePopular(jsonNode.get("time1").findPath("nome-slug").
 * toString());
 * equipeCasa.setSigla(jsonNode.get("time1").findPath("sigla").toString());
 * equipeCasa.setUrlLogoEquipe(jsonNode.get("time1").findPath("brasao").toString
 * ()); partidaUolDto.setTime1(equipeCasa);
 * 
 * // }
 * 
 * // for (Iterator i = jsonNode.get("time2").iterator(); i.hasNext();) {
 * 
 * Equipe equipeVisitante = new Equipe();
 * equipeVisitante.setId(Long.parseLong(jsonNode.get("time2").findPath("id").
 * toString()));
 * equipeVisitante.setNomeEquipe(jsonNode.get("time2").findPath("nome-completo")
 * .toString());
 * equipeVisitante.setNomePopular(jsonNode.get("time2").findPath("nome-slug").
 * toString());
 * equipeVisitante.setSigla(jsonNode.get("time2").findPath("sigla").toString());
 * equipeVisitante.setSigla(jsonNode.get("time2").findPath("brasao").toString())
 * ; partidaUolDto.setTime2(equipeVisitante);
 * 
 * // }
 * 
 * partidaUolDto.setPlacar1(jsonNode.get("placar1").toString());
 * partidaUolDto.setPlacar2(jsonNode.get("placar2").toString());
 * 
 * partidaUolDto.setDesempate_time1(jsonNode.get("desempate_time1").toString());
 * partidaUolDto.setDesempate_time2(jsonNode.get("desempate_time2").toString());
 * 
 * partidaUolDto.setEstadio(jsonNode.get("estadio").toString());
 * partidaUolDto.setLocal(jsonNode.get("local").toString());
 * partidaUolDto.setUrlPrejogo(jsonNode.get("url-prejogo").toString());
 * partidaUolDto.setUrlPosJogo(jsonNode.get("url-posjogo").toString());
 * partidaUolDto.setUrlVideo(jsonNode.get("url-video").toString());
 * partidaUolDto
 * .setEliminouJogoVolta(((jsonNode.get("eliminou-jogo-volta").toString() !=
 * "false") ? true : false)); partidaUolDto.setClassificouGolsFora(
 * (jsonNode.get("classificou-gols-fora").toString() != "false") ? true :
 * false);
 * 
 * partidaUolDto.setEstadio(jsonNode.get("estadio").toString());
 * partidaUolDto.setLocal(jsonNode.get("local").toString());
 * partidaUolDto.setIdMatch(Long.parseLong(jsonNode.get("id").toString()));
 * partidaUolDto.setDataHoraMatch(jsonNode.get("datahora").toString());
 * 
 */