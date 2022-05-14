import Image from "../../atoms/image";
import Template from "../template";
import FilterLogo from "../../../img/filter.png"
import SearchItem from "../../atoms/searchItem/";
import { useState } from "react";
import { searchSitters } from "../../../services/search.service";
import { getAccessToken } from "../../../services/user.service";

const SearchPage = () => {

  const [sitters, setSitters] = useState([])

  const handleSearch = () => {
    searchSitters(0, 10, "rating", "asc", getAccessToken(), handleError, handleSuccess)
  }

  const handleSuccess = (response) => {
    setSitters(response)
  }

  const handleError = (response) => {
    alert("Что-то пошло не так")
    console.log("Error: " + response)
  }

  const body =
    <div style={{ padding: '0 1vw', display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center' }}>
      <div style={{ paddingRight: '1vw' }} >
        <div style={{ display: 'flex' }}>
          <div>
            <input type="text" className="searchInput" placeholder="Кот, собака" />
          </div>
          <div>
            <button className="submitButton" onClick={handleSearch}>Найти</button>
          </div>
        </div>
      </div>
      <div>
        {sitters ? 
        sitters.map(sitter => {
          return (<SearchItem sitter={sitter} />)
        }) 
        :
        <div style={{ paddingTop: '2vw' }}>Ничего не найдено</div> 
       }
      </div>
    </div>
  return <Template body={body} />
}

export default SearchPage;