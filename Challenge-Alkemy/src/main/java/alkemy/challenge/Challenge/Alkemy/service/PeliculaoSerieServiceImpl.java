package alkemy.challenge.Challenge.Alkemy.service;

//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import alkemy.challenge.Challenge.Alkemy.entity.Genero;
import alkemy.challenge.Challenge.Alkemy.entity.PeliculaoSerie;
import alkemy.challenge.Challenge.Alkemy.repository.PeliculaoSerieRepository;

@Service
public class PeliculaoSerieServiceImpl implements PeliculaoSerieService {
	
	@Autowired
	private PeliculaoSerieRepository peliculaoSerieRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<PeliculaoSerie> findAll() {
		return peliculaoSerieRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<PeliculaoSerie> findAll(Pageable pageable) {
		return peliculaoSerieRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PeliculaoSerie> findById(Long id) {
		return peliculaoSerieRepository.findById(id);
	}

	@Override
	@Transactional
	public PeliculaoSerie save(PeliculaoSerie peliculaoSerie) {
		return peliculaoSerieRepository.save(peliculaoSerie);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		peliculaoSerieRepository.deleteById(id);
	}
	
}
