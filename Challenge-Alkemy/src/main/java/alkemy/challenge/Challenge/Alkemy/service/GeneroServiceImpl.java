package alkemy.challenge.Challenge.Alkemy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import alkemy.challenge.Challenge.Alkemy.entity.Genero;
import alkemy.challenge.Challenge.Alkemy.repository.GeneroRepository;

@Service

public class GeneroServiceImpl implements GeneroService{
	
	@Autowired
	private GeneroRepository generoRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Genero> findAll() {
		return generoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Genero> findAll(Pageable pageable) {
		return generoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Genero> findById(Long id) {
		return generoRepository.findById(id);
	}

	@Override
	@Transactional
	public Genero save(Genero genero) {
		return generoRepository.save(genero);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		generoRepository.deleteById(id);
		
	}

}
