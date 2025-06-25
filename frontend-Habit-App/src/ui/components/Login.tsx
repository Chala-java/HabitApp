
export default function Login() {
  return (
    <div className="container">
        <div className="row">
            <img src="" alt="" />
        <h3>Bienvenido</h3>
        <h1>Sistema de Gestión de Edificios</h1>
        <p>Por favor, inicie sesión en su cuenta.</p>
        </div>
        <div className="row">
            <form>
                <div>
                    <label htmlFor="username">Correo</label>
                    <input type="email" id="email" name="email" required />
                </div>
                <div>
                    <label htmlFor="password">Contraseña</label>
                    <input type="password" id="password" name="password" required />
                </div>
                <button type="submit">Iniciar Sesión</button>
            </form>
        </div>
    </div>
  )
}
