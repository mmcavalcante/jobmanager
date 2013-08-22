package br.com.jobmanager.controller;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.jobmanager.dao.DvdDao;
import br.com.jobmanager.interceptor.UserInfo;

@Resource
public class SistemaController {

	private static final Logger LOG = Logger.getLogger(SistemaController.class);

    private final Result result;
    private final Validator validator;
    private final UserInfo userInfo;
	private final DvdDao dao;

	public SistemaController(DvdDao dao, UserInfo userInfo, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
        this.validator = validator;
        this.userInfo = userInfo;
	}


	@Path("/sistema")
	@Get
	public void home() {
        result.include("sistema", "sistema");
    }

}
