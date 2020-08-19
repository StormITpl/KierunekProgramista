let place = {
    baseMethod() {
        console.log('Some base method');
    }
};

let cityGdansk = {
    ownMethod() {
        console.log('Some own method from Gdańsk');
    },

    __proto__: place
};

// place.baseMethod();

cityGdansk.baseMethod();
cityGdansk.ownMethod();
