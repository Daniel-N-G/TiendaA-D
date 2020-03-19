package ad.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao profesorDao;

	@Autowired
	private EmailDao emailDao;

	@Autowired
	private ModuloDao moduloDao;

	@Override
	public Profesor crearPorfesor(Profesor profesor) {

		return profesorDao.create(profesor);
	}

	@Override
	public void eliminarPorfesor(long idProfesor) {

		profesorDao.delete(idProfesor);
	}

	@Override
	public List<Profesor> listarProfesorPorNombreYApellidos(String nombreyapellidos) {

		return profesorDao.buscarPorfesorPorNombreYApellidos(nombreyapellidos);
	}

	@Override
	public List<Modulo> listarModulosNombre(String nombreModulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Modulo> listarModulosProfesor(long idProfesor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profesor> listarProfesores() {
		return profesorDao.listarPorfesores();
	}

	@Override
	public Profesor obtenerProfesor(long idProfesor) {
		return profesorDao.find(idProfesor);
	}

	@Override
	public List<Modulo> listarModulos() {
		return moduloDao.listarModulos();
	}

	@Override
	public Profesor anadirEmail(long idProfesor, Email email) {

		return profesorDao.anadirEmail(idProfesor, email);
	}

	@Override
	public Email crearEmail(Email email) {

		return emailDao.create(email);
	}

	@Override
	public void eliminarEmail(long idProfesor, Email email) {

		Profesor p = profesorDao.find(idProfesor);
		p.removeEmails(email);
		emailDao.update(email);

	}

}
