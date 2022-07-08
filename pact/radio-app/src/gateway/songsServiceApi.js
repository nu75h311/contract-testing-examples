import axios from 'axios';
import adapter from "axios/lib/adapters/http";

axios.defaults.adapter = adapter;

export class SongsServiceApi {

    constructor(url) {
        if (url === undefined || url === "") {
            url = "";
        }
        else if (url.endsWith("/")) {
            url = url.substr(0, url.length - 1)
        }
        this.url = url
    }

    async getAllSongs() {
        return axios.get(this.url + "/songs").then(res => res.data);
    }

    async getProduct(artist) {
        return axios.get("/songs?artist=" + artist).then(res => res.data);
    }
}

export default new SongsServiceApi();
