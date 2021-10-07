package br.com.springboot.services;

import br.com.springboot.model.Aluno;
import br.com.springboot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServices {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listAll(){
        return alunoRepository.findAll();
    }

    public void save(Aluno aluno){
        alunoRepository.save(aluno);
    }

    public Aluno get(Long id) {
        return alunoRepository.findById(id).get();
    }

    public void delete(Long id){
        alunoRepository.deleteById(id);
    }
}
