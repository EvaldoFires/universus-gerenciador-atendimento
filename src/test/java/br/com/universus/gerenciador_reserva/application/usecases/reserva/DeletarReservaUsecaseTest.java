package br.com.universus.gerenciador_reserva.application.usecases.reserva;

import br.com.universus.gerenciador_reserva.application.gateways.ReservaRepository;
import br.com.universus.gerenciador_reserva.domain.models.Reserva;
import br.com.universus.gerenciador_reserva.utils.ReservaHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeletarReservaUsecaseTest {

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private BuscarReservaUsecase buscarReservaUsecase;

    @InjectMocks
    private DeletarReservaUsecase usecase;

    private Reserva reserva;

    @BeforeEach
    void setup() {
        reserva = ReservaHelper.gerarReserva();
    }

    @Test
    void deveDeletarReservaComSucesso() {
        when(buscarReservaUsecase.buscarPorId(reserva.getId())).thenReturn(reserva);

        usecase.deletarPorId(reserva.getId());

        verify(buscarReservaUsecase).buscarPorId(reserva.getId());
        verify(reservaRepository).deletarPorId(reserva.getId());
    }
}

