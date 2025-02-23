package com.example.spring_test_project;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringTestProjectApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
	}

	@Test
	public void t0_1() {
		LinkedMultiValueMap<String, String> multipart = new LinkedMultiValueMap<>();
		multipart.add("dto", "new Object()");
		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<LinkedMultiValueMap<String, String>> entity = new HttpEntity<>(multipart, headers);
		ResponseEntity<String> result = restTemplate.exchange(
				"http://localhost:" + port + "/api/bc-analytics/executeV1",
				HttpMethod.POST,
				entity,
				String.class
		);

		assertSoftly(s -> {
			s.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
			s.assertThat(result.getBody()).isNotEmpty();
		});
	}

	@Test
	public void t1_1() {
		HttpEntity<String> entity = new HttpEntity<>("hello");

		ResponseEntity<String> result = restTemplate.exchange(
				"http://localhost:" + port + "/api/bc-analytics/executeV2",
				HttpMethod.POST,
				entity,
				String.class
		);

		assertSoftly(s -> {
			s.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
			s.assertThat(result.getBody()).isNotEmpty();
		});
	}


	@Test
	public void t1_2() {
		HttpEntity<String> entity = new HttpEntity<>("hello");

		ResponseEntity<String> result = restTemplate.exchange(
				"http://localhost:" + port + "/api/bc-analytics/executeV2",
				HttpMethod.POST,
				entity,
				String.class,
				"world"
		);

		assertSoftly(s -> {
			s.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
			s.assertThat(result.getBody()).isNotEmpty();
		});
	}


	@Test
	public void t2_1() {
		HttpEntity<String> entity = new HttpEntity<>("hello");

		ResponseEntity<String> result = restTemplate.exchange(
				"http://localhost:" + port + "/api/bc-analytics/executeV3",
				HttpMethod.POST,
				entity,
				String.class
		);

		assertSoftly(s -> {
			s.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
			s.assertThat(result.getBody()).isNotEmpty();
		});
	}


	@Test
	public void t2_2() {
		HttpEntity<String> entity = new HttpEntity<>("hello");

		ResponseEntity<String> result = restTemplate.exchange(
				"http://localhost:" + port + "/api/bc-analytics/executeV3",
				HttpMethod.POST,
				entity,
				String.class,
				"world"
		);

		assertSoftly(s -> {
			s.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
			s.assertThat(result.getBody()).isNotEmpty();
		});
	}

}
