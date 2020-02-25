package filmography.dao;

import filmography.model.Film;

import java.util.List;

public interface FilmDAO {
    List<Film> getAll();

    void addFilm(Film film);

    void deleteFilm(int id);

    void editFilm(Film film);

    Film getFilmById(int id);
}