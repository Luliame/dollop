package com.example.dollop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.dollop.model.Article;
import com.example.dollop.model.Comment;
import com.example.dollop.model.User;
import com.example.dollop.repository.ArticleRepository;
import com.example.dollop.repository.CommentRepository;
import com.example.dollop.repository.UserRepository;

@SpringBootApplication
@EnableMongoRepositories
public class DollopApplication implements CommandLineRunner {

    @Autowired
    private ArticleRepository articleRepo;
    
	@Autowired
    private CommentRepository commentRepo;

    @Autowired
    private UserRepository userRepo;

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
		
		User gaby = new User("gaby");
		User thomas = new User("thomas");

		userRepo.save(gaby);
		userRepo.save(thomas);
		
		Article a1 = new Article("bonjour", "ceci est un test");
		Article a2 = new Article("michel", "non");
		Article a3 = new Article("argent-pas-cher.com", "ceci n'est pas une arnaque");
		Article a4 = new Article("Amber heard a perdu !", "elle n'a pas été heared");

		articleRepo.save(a1);
		articleRepo.save(a2);
		articleRepo.save(a3);
		articleRepo.save(a4);

		Comment c1 = new Comment(gaby.getId(), 10);
		Comment c2 = new Comment(thomas.getId(), 3, "moi j'aime pas");
		Comment c3 = new Comment(thomas.getId(), 9, "moi j'aime bien");

		commentRepo.save(c1);
		commentRepo.save(c2);
		commentRepo.save(c3);

		a1.addCommentary(c1);
		a1.addCommentary(c2);
		a3.addCommentary(c3);

		articleRepo.save(a1);
		articleRepo.save(a2);
		articleRepo.save(a3);

		// gaby.addFavorite(a1);
		// userRepo.save(gaby);
	}
}
