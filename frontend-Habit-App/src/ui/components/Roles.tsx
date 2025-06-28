import "./Roles.css"
import tipocuenta from "/tipocuenta.png"
export default function Roles() {
  return (
    <div className="contenedor d-flex flex-column align-items-center w-75 h-75 rounded-3 bg-light">
        <section className="justify-content-center align-items-center text-center mb-4 mt-4">
            <img src={tipocuenta} alt="tipo cuenta" className="w-25 mx-auto" />
            <h1>Tipo de Cuenta</h1>
            <p>Elige el tipo de cuenta que mejor se adapte a tus necesidades</p>
        </section>
        <section className="roles d-flex gap-5 mx-auto">
            <div className="card-roles">
                <div className="d-flex justify-content-evenly">
                <i className="bi bi-person text-primary bg-transparent justify-content-around fs-4">Inquilino</i>
                <input type="checkbox" />
                </div>
                <label className="mx-4" htmlFor="">Ve tus pagos, has reclamos, etc</label>
            </div>
            <div className="card-roles">
                <div className="d-flex justify-content-evenly">
                <i className="bi bi-house text-primary bg-transparent justify-content-around fs-4">Propietario</i>
                <input type="checkbox" />
                </div>
                <label className="text-center" htmlFor="">Revisa tus contratos no tengas problemas y obten tu dinero bien</label>
            </div>
            <div className="card-roles">
                <div className="d-flex justify-content-evenly">
                <i className="bi bi-tools text-primary bg-transparent justify-content-around fs-4">Administrador</i>
                <input type="checkbox" />
                </div>
                <label className="text-center" htmlFor="">Gestiona tus edificios para un mejor futuro</label>
            </div>
        </section>
        <button className="btn-roles">Siguiente</button>
    </div>
  )
}
