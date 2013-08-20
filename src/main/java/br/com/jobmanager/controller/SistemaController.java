package br.com.jobmanager.controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.validator.Validations;
import br.com.jobmanager.dao.DvdDao;
import br.com.jobmanager.interceptor.UserInfo;
import br.com.jobmanager.model.Dvd;
import br.com.jobmanager.model.DvdRental;

@Resource
public class SistemaController {

	private static final Logger LOG = Logger.getLogger(SistemaController.class);

    private final Result result;
    private final Validator validator;
    private final UserInfo userInfo;
	private final DvdDao dao;

	/**
	 * Receives dependencies through the constructor.
	 * @param userInfo info on the logged user.
	 * @param result VRaptor result handler.
	 * @param validator VRaptor validator.
	 * @param factory dao factory.
	 */
	public SistemaController(DvdDao dao, UserInfo userInfo, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
        this.validator = validator;
        this.userInfo = userInfo;
	}


	@Path("/sistema")
	@Post
	public void add(final Dvd dvd, UploadedFile file) {
	    validator.checking(new Validations() {{
	    	if (dvd != null) {
	    		//that(dvd.getTitle(), is(notEmpty()), "login", "invalid_title");
	    		that(dvd.getType(), is(notNullValue()), "name", "invalid_type");
	    		//that(dvd.getDescription(), is(notEmpty()), "description", "invalid_description");
	    		that(dvd.getDescription().length() >= 6, "description", "invalid_description");
	    	}
		}});

		validator.onErrorForwardTo(UsersController.class).home();

		// is there a file?
		if (file != null) {
		    // usually we would save the file, in this case, we just log :)
			LOG.info("Uploaded file: " + file.getFileName());
		}

		dao.add(dvd);
		dao.add(new DvdRental(userInfo.getUser(), dvd));

		// you can add objects to result even in redirects. Added objects will
		// survive one more request when redirecting.
		result.include("notice", dvd.getTitle() + " dvd added");

		result.redirectTo(UsersController.class).home();
	}


	@Path("/sistema/{sistema.idSistema}")
	@Get
	public void show(Dvd dvd) {
	    result.include("dvd", dvd);
	}

	@Path("/sistema/pesquisa")
	@Get
	public void search(Dvd dvd) {
        if (dvd.getTitle() == null) {
            dvd.setTitle("");
        }

        result.include("dvds", this.dao.searchSimilarTitle(dvd.getTitle()));
    }

}
