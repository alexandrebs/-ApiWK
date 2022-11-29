package br.com.brazuca.brazucaapi.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.brazuca.brazucaapi.dto.DoadorDTO;
import br.com.brazuca.brazucaapi.entity.Doador;
import br.com.brazuca.brazucaapi.util.ScrapingUtil;

@Service
public class ScrapingService {

	@Autowired
	private DoadorService doadorService;

	@Autowired
	private ModelMapper modelMapper;


	public void cargaDoadores() throws IOException, ParseException {

		List<Doador> doadorDTO = new ArrayList<>();

		String strJson = ScrapingUtil.requestDoadores();

		Gson gson = new GsonBuilder().create();

		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

		JsonNode node = mapper.readTree(strJson);

		List<Doador> doa = mapper.readValue(strJson, new TypeReference<List<Doador>>() {
		});

		System.out.println(doa);

		cargaDoador(doa);

	}

	private void cargaDoador(List<Doador> doadorList) {

		List<@Valid Doador> listDoador = new ArrayList<>();

		Iterator<Doador> it = doadorList.iterator();

		for (Doador c : doadorList) {

			doadorService.inserirDoador(modelMapper.map(c, DoadorDTO.class));

		}
		listDoador.size();
	}

	

}
