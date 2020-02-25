package filmography.service;

import filmography.model.Film;

import java.util.List;

public interface FilmService {

    List<Film> getAll();

    void addFilm(Film film);

    void editFilm(Film film);

    void deleteFilm(int id);

    Film getFilmById(int id);
}
