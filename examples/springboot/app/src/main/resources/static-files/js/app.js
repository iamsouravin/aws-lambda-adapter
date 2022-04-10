function reqListener() {
    var pets = JSON.parse(this.responseText),
        waitSpan = document.getElementById('waitSpan'),
        petColumn = null,
        petCard = null,
        petImage = null,
        petNameHeader = null,
        petBreedLine = null,
        petDobLine = null,
        petsContainer = document.getElementById('petsContainer'),
        pet = null,
        dob = null;
    
    petsContainer.removeChild(waitSpan);
    for (var i in pets) {
        pet = pets[i];
        petColumn = document.createElement('div');
        petColumn.className = 'column';
        petCard = document.createElement('div');
        petCard.className = 'card';
        petImage = document.createElement('img');
        petImage.width = '150';
        petImage.height = '100';
        petImage.src = encodeURI('images/' + pet.breed + '.jpg');
        petCard.appendChild(petImage);
        petNameHeader = document.createElement('h3');
        petNameHeader.innerHTML = pet.name;
        petCard.appendChild(petNameHeader);
        petBreedLine = document.createElement('p');
        petBreedLine.innerHTML = pet.breed;
        petCard.appendChild(petBreedLine);
        dob = new Date(pet.dateOfBirth);
        petDobLine = document.createElement('p');
        petDobLine.innerHTML = 'Born on ' + dob.getUTCFullYear() + '-' + leftPadZero(dob.getUTCMonth() + 1) + '-' + leftPadZero(dob.getUTCDate());
        petCard.appendChild(petDobLine);
        petColumn.appendChild(petCard);
        petsContainer.appendChild(petColumn);
    }
}
function loadPets() {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", reqListener);
    oReq.open("GET", "pets");
    oReq.send();
}
function leftPadZero(val) {
    return val < 10 ? '0' + val : val;
}