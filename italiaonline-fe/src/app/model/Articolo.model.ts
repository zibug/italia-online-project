export interface Articolo {

    id: string;
    title: string;
    url: string;
    publishDate: Date;
    type: string;
    source: string;
}

export class ArticoloModel {
    id: string = '';
    title: string = '';
    url: string = '';
    publishDate: string = '';
    type: string = '';
    source: string = '';

    constructor() {
        
    }
}

