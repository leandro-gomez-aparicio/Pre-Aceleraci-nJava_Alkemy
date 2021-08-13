package alkemy.challenge.Challenge.Alkemy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import alkemy.challenge.Challenge.Alkemy.entity.Personaje;
import alkemy.challenge.Challenge.Alkemy.repository.PersonajeRepository;

@Service
public class PersonajeServiceImpl implements PersonajeService {
	
	@Autowired
	private PersonajeRepository personajeRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Personaje> findAll() {
		return personajeRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Personaje> findAll(Pageable pageable) {
		return personajeRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Personaje> findById(Long id) {
		return personajeRepository.findById(id);
	}

	@Override
	@Transactional
	public Personaje save(Personaje personaje) {
		return personajeRepository.save(personaje);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		personajeRepository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Personaje> listar() {
		return (List<Personaje>) personajeRepository.findAll();
	}

	
}
