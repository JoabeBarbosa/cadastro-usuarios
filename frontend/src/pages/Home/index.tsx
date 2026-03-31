import './style.css'
import Trash from '../../assets/red-trash-can-icon.svg'
import api from '../../services/api/api';
import { useEffect, useState, useRef } from 'react';
//--- Interface
interface GetUserDTO {
  userId: string;
  userName: string;
  userAge: number;
  userEmail: string;
}
//---
interface CreateUserDTO{
  userName: string;
  userAge: number;
  userEmail: string;
}
//---
function Home() {
  const [users, setUsers] = useState<GetUserDTO[]>([]);
  //---
  const inputName = useRef<HTMLInputElement>(null);
  const inputAge = useRef<HTMLInputElement>(null);
  const inputEmail = useRef<HTMLInputElement>(null);

  // let usersArray: User[] = [];
//---
async function getUsers(){
  try{
    const axiosResponse = await api.get<GetUserDTO[]>("/users");
    setUsers(axiosResponse.data);
    console.log(users);
  } catch(error){
    console.log("Failed to fetch users: ",error);
  }
//---
}

useEffect(() => {
  getUsers();
},[]);
//---
async function createUsers() {
  const userData: CreateUserDTO = {
      userName: inputName.current?.value ?? "",
      userAge: Number(inputAge.current?.value),
      userEmail: inputEmail.current?.value ?? ""
    };
  //---
  try{
    const response = await api.post<CreateUserDTO>("/users",userData);
    console.log("User created: ",response.data);
    //---
    inputName.current!.value = "";
    inputAge.current!.value = "";
    inputEmail.current!.value = "";
    //---
    getUsers();
  }catch(error){
    console.error("Failed to create user: ",error);
  }
  //---
}
//---
async function deleteUsers(id:string){
  
  try{
    const response = await api.delete<void>(`/users/${id}`) //no body -> void
    console.log("User deleted: ",response.data);
    //---
    setUsers(prevUsers => 
      prevUsers.filter( user => user.userId !==id)
  );
    //---
  }catch(error){
    console.error("Failed to delete user: ",error);
  }
//---
}
//---
  return (
    <>
      <div className='container'>
        <form action="">
          <h1>Cadastro de Usuário</h1>
          <input type="text" name='nome' placeholder='Nome' ref={inputName} />
          <input type="number" name='idade' placeholder='Idade' ref={inputAge} />
          <input type="email" name='email' placeholder='Email' ref={inputEmail} />
          <button type='button' onClick={createUsers}>Cadastrar</button>
        </form>
        
        {
          users.map((user) => (
              <div key={user.userId} className='card'>
                <div>
                  <p>Nome:<span> {user.userName} </span> </p>
                  <p>Idade:<span> {user.userAge} </span> </p>
                  <p>Email:<span> {user.userEmail} </span> </p>
                </div>
                <button onClick={() => deleteUsers(user.userId)}>
                  <img src={Trash} alt="Trash can" />
                </button>
              </div>
            )
          )
        }
      </div>
    </>
  )
}

export default Home