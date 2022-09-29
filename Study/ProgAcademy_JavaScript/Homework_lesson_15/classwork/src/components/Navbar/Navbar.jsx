import { menu } from "./menu"
import styles from "./navbar.module.scss"



function Navbar (params) {
    return (
        <div className={styles.menu}>
            <ul className={styles.elements} > 
            {menu.map((element, index)=>(
                    <li className= {styles.point} key={element.title + index}>
                        <a className={styles.points} href={element.link} key={'a'+ element.title + index} >{element.title}</a>
                    </li>
            ))
            }
             </ul>
        </div>
    )
}
export default Navbar