import Logo from '/Logo.png';

import './Login.css';

export default function Login() {
  return (
      <div className="login-contenedor mx-auto my-auto d-flex flex-column align-items-center justify-content-center">
        <div className="row text-center">
        <img src={Logo} alt="logo" className="mx-auto" />
        <h3>Bienvenido</h3>
        <h1>Sistema de Gestión de Edificios</h1>
        <p>Por favor, inicie sesión en su cuenta.</p>
        </div>
        <div className="row text-start">
            <form>
                <div className='row'>
                    <label htmlFor="username">Correo</label>
                    <input className='input' type="email" id="email" name="email" placeholder=' juan@gmail.com' required />
                </div>
                <div className='row'>
                    <label htmlFor="password">Contraseña</label>
                    <input className='input' type="password" id="password" name="password" placeholder=' ******' required />
                </div>
                <div className='d-flex flex-row justify-content-between'>
                <label htmlFor=""><input type="checkbox"/> Acuerdate de mi</label>
                <label className='text-primary' htmlFor="">¿Has olvidado tu contraseña?</label>
                </div>
                <div>
                <button type="submit" className='btn-login'>Iniciar Sesión</button>
                <label htmlFor="" className='mb-3'>O continuar con</label>
                <div className='d-flex flex-row gap-3 mb-5'> 
                <i className="bi bi-google text-danger"> Google</i>
                <i className="bi bi-facebook text-primary"> Facebook</i>
                </div>
                <div className='registrate d-flex flex-row gap-1'>
                <p>¿Eres nuevo/a? </p>
                <p className='text-primary'> Registrate ahora</p>
                </div>
                </div>
            </form>
        </div>
    </div>
  )
}
