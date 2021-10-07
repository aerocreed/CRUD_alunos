package br.com.springboot.controller;

import java.util.List;
import java.util.Optional;

import br.com.springboot.model.Aluno;
import br.com.springboot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Permite acesso do Front na porta do AngularJS
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AlunoController implements WebMvcConfigurer {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/{id}")
    public Aluno GetById(@PathVariable("id") Long id) {
        Optional<Aluno> alunoFind = this.alunoRepository.findById(id);
        return alunoFind.orElse(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> Put(@PathVariable("id") Long id, @RequestBody Aluno newAluno){
        Optional<Aluno> oldAluno = alunoRepository.findById(id);
        if(oldAluno.isPresent()){
            Aluno aluno = oldAluno.get();
            aluno.setNome(newAluno.getNome());
            aluno.setNome_social(newAluno.getNome_social());
            aluno.setCpf(newAluno.getCpf());
            aluno.setData_nasc(newAluno.getData_nasc());
            aluno.setGenero(newAluno.getGenero());
            aluno.setCor(newAluno.getCor());
            aluno.setE_mail(newAluno.getE_mail());
            aluno.setTelefone(newAluno.getTelefone());
            aluno.setNacionalidade(newAluno.getNacionalidade());
            aluno.setPossui_neces(newAluno.isPossui_neces());
            aluno.setPossui_neces(newAluno.isPossui_neces());
            aluno.setSitua_itiner(newAluno.isSitua_itiner());

            alunoRepository.save(aluno);
            return new ResponseEntity<>(aluno, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if(aluno.isPresent()){
            alunoRepository.delete(aluno.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public Aluno Post(@RequestBody Aluno aluno) {
        return this.alunoRepository.save(aluno);
    }

    @GetMapping("/list")
    public List<Aluno> list() {
        return this.alunoRepository.findAll();
    }

}
