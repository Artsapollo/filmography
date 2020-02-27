package filmography.service.impl;

import filmography.dao.FilmDAO;
import filmography.dao.jdbc.FilmDAOImpl;
import filmography.model.Film;
import filmography.service.FilmService;

import java.util.List;

public class FilmServiceImpl implements FilmService {

    private static FilmDAO filmDAO = new FilmDAOImpl();

    @Override
    public List<Film> getAll() {
        return filmDAO.getAll();
    }

    @Override
    public void addFilm(Film film) {
        filmDAO.addFilm(film);
    }

    @Override
    public void editFilm(Film film) {
        filmDAO.editFilm(film);
    }

    @Override
    public void deleteFilm(int id) {
        filmDAO.deleteFilm(id);
    }

    @Override
    public Film getFilmById(int id) {
        return filmDAO.getFilmById(id);
    }
}
