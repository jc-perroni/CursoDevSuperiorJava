package entities;

import java.util.Objects;

public class Candidato {

    private String candidato;
    private int votos;

    public Candidato(String candidato, int votos) {
        this.candidato = candidato;
        this.votos = votos;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidato candidato1 = (Candidato) o;
        return Objects.equals(candidato, candidato1.candidato);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(candidato);
    }
}
