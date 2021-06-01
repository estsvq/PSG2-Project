/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Contact;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class SupportService {

    String baseUrl = "http://psg2-g2-23.indevspace.xyz/webservices/rest.php";
    String version = "1.3";
    String auth_user = "admin";
    String auth_pwd = "admin";
    String operation = "{\"operation\": \"core/get\", \"class\":\"Person\",\"key\":\"SELECT Person WHERE org_id = 2\",\"output_fields\":\"friendlyname, email, phone, team_list\"}";

    @SuppressWarnings("unchecked")
    public List<Contact> getContacts() throws IOException {

        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> paramsDict = new LinkedMultiValueMap<String, String>();

        paramsDict.add("version", version);
        paramsDict.add("auth_user", auth_user);
        paramsDict.add("auth_pwd", auth_pwd);
        paramsDict.add("json_data", operation);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(paramsDict,
                headers);

        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, request, String.class);
        String jsonString = response.getBody();

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(jsonString, Map.class);

        return ((Map<String, Map<String, Object>>) map.get("objects")).values().stream().map(x -> {
            Map<String, Object> attributes = (Map<String, Object>) x.get("fields");
            String name = (String) attributes.get("friendlyname");
            String email = (String) attributes.get("email");
            String phone = (String) attributes.get("phone");
            String role = ((List<Map<String, String>>) attributes.get("team_list")).get(0).get("role_id_friendlyname");

            return new Contact(name, email, phone, role);
        }).collect(Collectors.toList());
    }
}
