import "./Roles.css"
import tipocuenta from "/tipocuenta.png"
export default function Roles() {
  return (
    <div className="contenedor d-flex flex-column align-items-center w-75 h-75">
        <section className="justify-content-center align-items-center">
            <img src={tipocuenta} alt="tipo cuenta" className="w-25 mx-auto" />
            <h1>Tipo de Cuenta</h1>
            <p>Elige el tipo de cuenta que mejor se adapte a tus necesidades</p>
        </section>
        <section className=" roles d-flex gap-5 mx-auto">
            <div className="card-roles">
                <div className="d-flex justify-content-evenly">
                <i className="bi bi-person">Inquilino</i>
                <input type="checkbox" />
                </div>
                <label htmlFor="">Ve tus pagos, has reclamos, etc</label>
            </div>
            <div className="card-roles">
                <div className="d-flex justify-content-evenly">
                <i className="bi bi-house">Propietario</i>
                <input type="checkbox" />
                </div>
                <label htmlFor="">Revisa tus contratos no tengas problemas y obten tu dinero bien</label>
            </div>
            <div className="card-roles">
                <div className="d-flex justify-content-evenly">
                <i className="bi bi-tools">Administrador</i>
                <input type="checkbox" />
                </div>
                <label htmlFor="">Gestiona tus edificios para un mejor futuro</label>
            </div>
        </section>
        <button>Siguiente</button>
    </div>
  )
}
