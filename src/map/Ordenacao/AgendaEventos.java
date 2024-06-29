package map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;


    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void addEvento(LocalDate data, String nome, String atracao) {
        eventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        // Criando um TreeMap a partir do eventosMap para ordenar as datas
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        // Imprimindo o TreeMap, que estará ordenado pelas datas
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proxData = null;
        Evento proxEvento = null;

        // Criando um TreeMap a partir do eventosMap para ordenar as datas
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);

        // Iterando pelo TreeMap ordenado
        for (var entry : eventosTreeMap.entrySet()) {
            // Verificando se a data do evento é igual ou depois da data atual
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                // Se sim, armazena a próxima data e o próximo evento
                proxData = entry.getKey();
                proxEvento = entry.getValue();
                // Imprime informações do próximo evento encontrado
                System.out.println("O próximo evento: " + entry.getValue() + " acontecerá na data " + entry.getKey());
                break; // Encerra o loop após encontrar o próximo evento válido
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        // Adiciona eventos à agenda
        agendaEventos.addEvento(LocalDate.of(2020, Month.AUGUST, 11), "Evento 1", "Atração 1");
        agendaEventos.addEvento(LocalDate.of(2022, 5, 19), "Evento 2", "Atração 2");
        agendaEventos.addEvento(LocalDate.of(2016, 9, 2), "Evento 3", "Atração 3");
        agendaEventos.addEvento(LocalDate.of(2024, 6, 29), "Evento 4", "Atração 4");
        agendaEventos.addEvento(LocalDate.of(2025, 1, 22), "Evento 5", "Atração 5");

        // Exibe a agenda completa de eventos
        agendaEventos.exibirAgenda();

        // Obtém e exibe o próximo evento na agenda
        agendaEventos.obterProximoEvento();
    }
}
