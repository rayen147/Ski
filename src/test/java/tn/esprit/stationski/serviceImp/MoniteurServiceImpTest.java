package tn.esprit.stationski.serviceImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.stationski.entities.Cours;
import tn.esprit.stationski.entities.Moniteur;
import tn.esprit.stationski.repository.CoursRepository;
import tn.esprit.stationski.repository.MoniteurRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MoniteurServiceImpTest {

    @InjectMocks
    private MoniteurServiceImp moniteurService;

    @Mock
    private MoniteurRepository moniteurRepository;

    @Mock
    private CoursRepository coursRepository;

    private Moniteur moniteur;
    private Cours cours;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        moniteur = Moniteur.builder()
                .numMoniteur(1L)
                .nomM("Doe")
                .prenomM("John")
                .dateRecru(LocalDate.now())
                .cours(Set.of())
                .build();

        cours = new Cours();
        cours.setNum(1L); // Assuming Cours entity has an idCours field.
    }

    @Test
    void retrieveAllMoniteurs() {
        when(moniteurRepository.findAll()).thenReturn(List.of(moniteur));

        var result = moniteurService.retrieveAllMoniteurs();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(moniteurRepository, times(1)).findAll();
    }

    @Test
    void addMoniteur() {
        when(moniteurRepository.save(moniteur)).thenReturn(moniteur);

        var result = moniteurService.addMoniteur(moniteur);

        assertNotNull(result);
        assertEquals(moniteur.getNomM(), result.getNomM());
        verify(moniteurRepository, times(1)).save(moniteur);
    }

    @Test
    void updateMoniteur() {
        when(moniteurRepository.save(moniteur)).thenReturn(moniteur);

        var result = moniteurService.updateMoniteur(moniteur);

        assertNotNull(result);
        assertEquals(moniteur.getNumMoniteur(), result.getNumMoniteur());
        verify(moniteurRepository, times(1)).save(moniteur);
    }

    @Test
    void retrieveMoniteur() {
        when(moniteurRepository.findById(1L)).thenReturn(Optional.of(moniteur));

        var result = moniteurService.retrieveMoniteur(1L);

        assertNotNull(result);
        assertEquals(moniteur.getNumMoniteur(), result.getNumMoniteur());
        verify(moniteurRepository, times(1)).findById(1L);
    }

    @Test
    void removeMoniteur() {
        doNothing().when(moniteurRepository).deleteById(1L);

        moniteurService.removeMoniteur(1L);

        verify(moniteurRepository, times(1)).deleteById(1L);
    }

}
