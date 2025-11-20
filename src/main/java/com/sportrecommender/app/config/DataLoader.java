package com.sportrecommender.app.config;

import com.sportrecommender.app.model.Activity;
import com.sportrecommender.app.model.Sport;
import com.sportrecommender.app.repository.ActivityRepository;
import com.sportrecommender.app.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("🔄 Limpando e populando banco de dados...");

        sportRepository.deleteAll();
        activityRepository.deleteAll();

        System.out.println("🗑️  Dados antigos removidos!");

        createActivities();
        createSports();

        System.out.println("✅ Banco populado com " + sportRepository.count() + " esportes e " + activityRepository.count() + " atividades!");
    }

    private void createActivities() {
        List<Activity> activities = Arrays.asList(
                new Activity(null, "correr", "Gostar de corrida, velocidade e resistência"),
                new Activity(null, "pular", "Gostar de saltar, altura e acrobacias"),
                new Activity(null, "pensar", "Gostar de estratégia, raciocínio e planejamento"),
                new Activity(null, "nadar", "Gostar de água, natação e esportes aquáticos"),
                new Activity(null, "lutar", "Gostar de combate, luta e artes marciais"),
                new Activity(null, "dançar", "Gostar de ritmo, dança e expressão corporal"),
                new Activity(null, "atirar", "Gostar de precisão, mira e concentração"),
                new Activity(null, "pedalar", "Gostar de ciclismo, velocidade e resistência"),
                new Activity(null, "equilibrar", "Gostar de equilíbrio, coordenação motora"),
                new Activity(null, "escalar", "Gostar de escalada, desafios físicos e alturas"),
                new Activity(null, "jogar", "Gostar de jogos em equipe, cooperação"),
                new Activity(null, "competir", "Gostar de competição, desafios e superação")
        );

        activityRepository.saveAll(activities);
    }

    private void createSports() {
        List<Sport> sports = Arrays.asList(
                // Esportes coletivos
                new Sport(null, "Basquete",
                        "Esporte coletivo dinâmico ideal para quem gosta de saltar e tem boa altura. Exige velocidade, coordenação, trabalho em equipe e pensamento estratégico rápido.",
                        1.75, 2.20, "any",
                        Arrays.asList("pular", "correr", "jogar", "competir"), null),

                new Sport(null, "Futebol",
                        "Esporte coletivo mais popular do mundo. Exige resistência, velocidade, técnica com os pés, visão de jogo e espírito de equipe.",
                        null, null, "any",
                        Arrays.asList("correr", "jogar", "competir", "pensar"), null),

                new Sport(null, "Vôlei",
                        "Esporte coletivo que exige coordenação, reflexos rápidos, saltos e trabalho em equipe sincronizado.",
                        1.70, 2.10, "any",
                        Arrays.asList("pular", "jogar", "competir", "correr"), null),

                new Sport(null, "Handebol",
                        "Esporte coletivo dinâmico que mistura elementos do futebol e basquete. Exige velocidade, arremesso potente e estratégia de equipe.",
                        1.70, 2.00, "any",
                        Arrays.asList("correr", "pular", "jogar", "competir"), null),

                new Sport(null, "Futsal",
                        "Versão indoor do futebol. Jogo rápido que exige técnica apurada, reflexos, visão de jogo e habilidade em espaços reduzidos.",
                        null, null, "any",
                        Arrays.asList("correr", "pensar", "jogar", "competir"), null),

                new Sport(null, "Rugby",
                        "Esporte coletivo intenso que exige força, coragem, resistência e trabalho em equipe. Para quem não tem medo de contato físico.",
                        1.70, null, "any",
                        Arrays.asList("correr", "lutar", "jogar", "competir"), null),

                new Sport(null, "Polo Aquático",
                        "Esporte coletivo praticado na água que combina natação, força, resistência e estratégia de jogo. Muito exigente fisicamente.",
                        1.75, null, "any",
                        Arrays.asList("nadar", "lutar", "jogar", "competir"), null),

                // Esportes individuais - combate
                new Sport(null, "MMA (Artes Marciais Mistas)",
                        "Esporte de combate completo que mistura várias artes marciais. Exige preparo físico excepcional, técnica, estratégia e coragem.",
                        null, null, "any",
                        Arrays.asList("lutar", "correr", "pensar", "competir"), null),

                new Sport(null, "Judô",
                        "Arte marcial japonesa que ensina defesa pessoal, disciplina e respeito. Excelente para desenvolvimento físico e mental.",
                        null, null, "any",
                        Arrays.asList("lutar", "pensar", "equilibrar", "competir"), null),

                new Sport(null, "Boxe",
                        "Arte marcial nobre focada em socos. Desenvolve força, velocidade, resistência cardiovascular e disciplina mental.",
                        null, null, "any",
                        Arrays.asList("lutar", "correr", "competir"), null),

                new Sport(null, "Taekwondo",
                        "Arte marcial coreana focada em chutes espetaculares. Desenvolve flexibilidade, força explosiva e disciplina.",
                        null, null, "any",
                        Arrays.asList("lutar", "pular", "competir", "equilibrar"), null),

                new Sport(null, "Esgrima",
                        "Arte marcial europeia com espadas. Exige reflexos ultra-rápidos, estratégia, elegância e precisão.",
                        null, null, "any",
                        Arrays.asList("pensar", "lutar", "competir", "equilibrar"), null),

                // Esportes individuais - resistência
                new Sport(null, "Atletismo",
                        "Conjunto de modalidades incluindo corrida, saltos e lançamentos. Ideal para quem ama velocidade e superação de limites.",
                        null, null, "any",
                        Arrays.asList("correr", "pular", "competir"), null),

                new Sport(null, "Natação",
                        "Esporte completo praticado na água. Trabalha todos os músculos, melhora capacidade cardiovascular e tem baixo impacto.",
                        null, null, "any",
                        Arrays.asList("nadar", "correr", "competir"), null),

                new Sport(null, "Ciclismo",
                        "Esporte de resistência praticado em bicicletas. Ótimo para quem ama velocidade, natureza e desafios de longa distância.",
                        null, null, "any",
                        Arrays.asList("pedalar", "correr", "competir"), null),

                new Sport(null, "Triathlon",
                        "Esporte que combina natação, ciclismo e corrida. Para atletas completos que amam desafios extremos de resistência.",
                        null, null, "any",
                        Arrays.asList("nadar", "pedalar", "correr", "competir"), null),

                // Esportes de precisão
                new Sport(null, "Tiro Esportivo",
                        "Esporte de precisão que exige concentração máxima, controle respiratório, paciência e foco mental absoluto.",
                        null, null, "any",
                        Arrays.asList("atirar", "pensar", "competir"), null),

                new Sport(null, "Tênis",
                        "Esporte individual ou em duplas que exige agilidade, estratégia, resistência e técnica refinada.",
                        null, null, "any",
                        Arrays.asList("correr", "pensar", "competir", "pular"), null),

                // Esportes radicais
                new Sport(null, "Escalada",
                        "Esporte radical que desafia limites físicos e mentais. Requer força, estratégia, equilíbrio e coragem.",
                        null, null, "any",
                        Arrays.asList("escalar", "pensar", "equilibrar", "competir"), null),

                new Sport(null, "Surfe",
                        "Esporte aquático radical praticado sobre ondas. Exige equilíbrio, coragem, leitura do mar e conexão com a natureza.",
                        null, null, "any",
                        Arrays.asList("nadar", "equilibrar", "competir"), null),

                new Sport(null, "Skate",
                        "Esporte urbano radical que exige equilíbrio, criatividade, coragem e muita persistência para aprender manobras.",
                        null, null, "any",
                        Arrays.asList("pular", "equilibrar", "competir"), null),

                new Sport(null, "Parkour",
                        "Disciplina urbana que transforma a cidade em playground. Exige agilidade, criatividade, coragem e condicionamento físico.",
                        null, null, "any",
                        Arrays.asList("pular", "correr", "escalar", "equilibrar"), null),

                // Esportes artísticos
                new Sport(null, "Ginástica Artística",
                        "Esporte que combina força, flexibilidade, equilíbrio e acrobacias espetaculares em diversos aparelhos.",
                        1.50, 1.75, "any",
                        Arrays.asList("pular", "dançar", "equilibrar", "competir"), null),

                new Sport(null, "Ginástica Rítmica",
                        "Esporte que combina dança, flexibilidade e uso artístico de aparelhos. Muito praticada por mulheres, mas aberta a todos.",
                        1.50, 1.75, "female",
                        Arrays.asList("dançar", "pular", "equilibrar"), null),

                new Sport(null, "Balé",
                        "Dança clássica que desenvolve postura perfeita, flexibilidade, força, controle corporal e expressão artística.",
                        null, null, "any",
                        Arrays.asList("dançar", "pular", "equilibrar"), null),

                new Sport(null, "Dança de Salão",
                        "Dança em casal que combina ritmo, coordenação, elegância, conexão entre parceiros e musicalidade.",
                        null, null, "any",
                        Arrays.asList("dançar", "equilibrar"), null),

                // Esportes mentais
                new Sport(null, "Xadrez",
                        "Jogo de tabuleiro estratégico milenar. Perfeito para quem adora pensar, planejar e desenvolver raciocínio lógico profundo.",
                        null, null, "any",
                        Arrays.asList("pensar", "competir"), null),

                new Sport(null, "E-Sports",
                        "Competições profissionais de jogos eletrônicos. Exige reflexos ultra-rápidos, estratégia, trabalho em equipe e dedicação intensa.",
                        null, null, "any",
                        Arrays.asList("pensar", "jogar", "competir"), null)
        );

        sportRepository.saveAll(sports);
    }
}