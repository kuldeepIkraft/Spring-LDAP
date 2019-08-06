package com.memorynotfound.ldap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.crypto.EncryptedPrivateKeyInfo;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired private PersonRepository personRepository;
    @Autowired private GroupRepository groupRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
    @RequestMapping("/addUser")
    public String addUser(@RequestParam(value="uid") String uid,@RequestParam(value="fName") String fname,@RequestParam(value="lName") String lName
    		,@RequestParam(value="mail") String mail,@RequestParam(value="pwd") String pwd) {
		try {
			
			/*EncryptedPrivateKeyInfo info = new EncryptedPrivateKeyInfo(pwd.getBytes());
			Encr*/
			Person person = new Person(uid, fname, lName,mail,pwd);
			personRepository.create(person);
			//groupRepository.addMemberToGroup("managers", person);
			return "Added the User "+person.getFullName();
		} catch (Exception e) {
			log.error("Exception :", e);
			return e.getMessage();
		}
    }
    
    @RequestMapping("/getPeople")
    public String getAll() {
    	 List<Person> names = personRepository.findAll();
         log.info("names: " + names);
         return names.toString();
    }
    
    @RequestMapping("/getGroup")
    public String getGroups() {
    	 List<Group> groups = groupRepository.findAll();
    	    log.info("groups: " + groups);
         return groups.toString();
    }
    
    @RequestMapping("/")
    public String getGroups(@RequestParam(value="ticket") String ticket) {
         return "Your Ticket is "+ticket;
    }

    @PostConstruct
    public void setup(){
        log.info("Spring LDAP + Spring Boot Configuration Example");

        List<Person> names = personRepository.findAll();
        log.info("names: " + names);

       // System.exit(-1);
    }

}
