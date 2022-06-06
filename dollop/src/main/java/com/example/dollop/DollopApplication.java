package com.example.dollop;

import com.example.dollop.model.Article;
import com.example.dollop.model.Comment;
import com.example.dollop.model.User;
import com.example.dollop.repository.ArticleRepository;
import com.example.dollop.repository.CommentRepository;
import com.example.dollop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DollopApplication implements CommandLineRunner {

    @Autowired
    ArticleRepository articleRepo;
    @Autowired
    CommentRepository commentRepo;
    @Autowired
    UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(DollopApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		populate_test();
	}

	private void populate_test(){
		articleRepo.deleteAll();
		userRepo.deleteAll();
		commentRepo.deleteAll();

		articleRepo.save(new Article("bonjour", "ceci est un test"));
		articleRepo.save(new Article("michel", "non"));
		articleRepo.save(new Article("agrandissez votre penis", "ceci n'est pas une arnaque"));
		articleRepo.save(new Article("Amber heard a perdu !", "elle n'a pas été heared"));

		User gaby = new User("gaby");
		userRepo.save(gaby);
		commentRepo.save(new Comment(gaby.getId(), 10));
	}
}
