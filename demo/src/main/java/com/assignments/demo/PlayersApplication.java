
package com.assignments.demo;

import com.assignments.demo.model.Player;
import com.assignments.demo.service.PlayersService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.InputStream;
import java.io.InputStreamReader;


@SpringBootApplication
public class PlayersApplication {


	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(PlayersApplication.class, args);
		PlayersService playersService = context.getBean(PlayersService.class);
		loadCSVFile(playersService);
	}

	private static void loadCSVFile(PlayersService playersService) {

		InputStream inputStream = ClassLoader.getSystemResourceAsStream("player.csv");
        assert inputStream != null;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		CsvToBeanBuilder<Player> csvToBeanBuilder = new CsvToBeanBuilder<>(inputStreamReader);
		csvToBeanBuilder.withType(Player.class);

		csvToBeanBuilder.build().parse().forEach(playersService::createPlayer);

	}

}
