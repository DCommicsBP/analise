package br.com.daione.pavan.capeonato.handebol.api.controller;

import br.com.daione.pavan.capeonato.handebol.business.PayerService;
import br.com.daione.pavan.capeonato.handebol.infraestructure.entities.Player;
import br.com.daione.pavan.capeonato.handebol.infraestructure.repository.PlayerRepository;
import br.com.daione.pavan.capeonato.handebol.infraestructure.utils.UtilError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

	@Autowired
	private PayerService playerService;

	@Autowired
	private PlayerRepository repository; 
	
	@Autowired
	private UtilError utilError; 
	
    @PostMapping("/")
    public Mono<Player> create(@RequestBody Player player){
        return this.playerService.create(player);
    }
    
    @GetMapping("/")
    public Flux<Player> players(){
    	return this.repository.findAll(); 
    }
    
    @GetMapping("/{id}")
    public Mono<Player> findPlayer(@PathVariable  String id){
        return this.playerService.find(id)
                .doOnError(x-> this.utilError.internalServerError("Não é possível encontrar o registro. "));
    }

    @PatchMapping("/{id}")
    public Mono<Player> update(@PathVariable String id, @RequestBody Player newPlayer){
        return this.playerService.update(id, newPlayer)
                .doOnError(x-> this.utilError.internalServerError("Não foi possível fazer o update do registro. "));
    }

    @DeleteMapping("/{id}")
    public Mono<Player> delete(@PathVariable String id){
        return this.playerService.delete(id)
                .doOnError(x-> this.utilError.internalServerError("Não foi possível encontrar o dados para excluí-lo"));
    }
    
}
