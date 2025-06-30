import "./Registro.css";
import Logo from "/Logo.png";

export const Registro = () => {
  return (
    <section className="login py-3">
      <section className="container justify-content-center align-items-start ">
        <div className="row justify-content-center ">
          <div className="sombra col-12 col-md-8 col-lg-6 box-shadow  ">
            <div className="texto-logo  justify-content-start align-items-center flex-column ">
              <img src={Logo} alt="logo" className="" />
              <h3>Bienvenido</h3>
              <h1>Sistema de Gestión de Edificios</h1>
              <p>Por favor, inicie sesión en su cuenta.</p>
            </div>
            <section className="row w-100 justify-content-center">
              <form className="col-12 col-md-10 d-flex flex-column" action="">
                {/* Correo completo */}
                <div className="mb-3">
                  <label htmlFor="correo" className="form-label col-12 text-start">Correo</label>
                  <input className="form-control input-personalizado" type="email" id="correo" placeholder="correo" />
                </div>

                {/* Nombre y Apellido */}
                <div className="row mb-3  flex-row">
                  <div className="col-md-6 col-6">
                    <div className="form-group">
                      <label htmlFor="nombre" className="form-label col-12 text-start">Nombre</label>
                      <input className="form-control input-personalizado " type="text" placeholder="nombre"/>
                    </div>

                  </div>
                  <div className="col-md-6 col-6">
                    <label className="form-label col-12 text-start">Apellido</label>
                    <input className="form-control input-personalizado" type="text" placeholder="apellido" />
                  </div>
                </div>

                {/* contraseñas */}
                <div className="row mb-3  flex-row">
                  <div className="col-md-6 col-6">
                    <label className="form-label col-12 text-start">Contraseña</label>
                    <input className="form-control input-personalizado" type="password" placeholder="contraseña" />
                  </div>
                  <div className="col-md-6 col-6">
                    <label className="form-label col-12 text-start col-12 text-start">Confirmar Contraseña</label>
                    <input className="form-control input-personalizado" type="password"placeholder="confirma contraseña" />
                  </div>
                </div>

              </form>
              <div className="col-12 col-lg-3">
                <button type="submit" className='btn-login'>Iniciar Sesión</button>

              </div>
            </section>
          </div>
        </div>
      </section>
    </section>
  );
};
