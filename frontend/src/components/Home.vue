<script setup>

import { ref } from 'vue';
import { onMounted } from 'vue';

const departure = ref("");
const arrival = ref("");
const flights = ref([])
const checkFlights = ref(false)
// fetch flights data
async function flightData(allFlights, start, end) {
  try{
    let response

    if(allFlights){
      response = await fetch("http://localhost:8080/api/flights");
      console.log(response)
    }else{
       response = await fetch(`http://localhost:8080/api/flights/search?departure=${start}&arrival=${end}`);
       //console.log(response)
    }  
    if(!response.ok){
      throw new error("Http fetchin error", error)
    }

    const data = await response.json();

    if(data.length === 0){
      checkFlights.value = true
    }else{
      checkFlights.value = false
      console.log(data)
      flights.value = data;
    }
  }catch(error){
    console.log(error)
  }
}


</script>

<template>
  <div class="container">
    <div class="searchFlights">
      <input v-model="departure" placeholder="Alugspunkt">
      <input v-model="arrival" placeholder="Sihtpunkt">
      <input type="date" id="datePicker" name="date">
      <input type="date" id="datePicker" name="date" >
      <input type="number" id="numPeople" name="numPeople" min="1" max="10" value="1">
      <button @click="flightData(false, departure, arrival)">Otsi</button>
      <button @click="flightData(true, departure, arrival)">Näite kõiki lende</button>
    </div>
    <div class="flights">
      <h1>Flights</h1>
      <div v-for="item in flights" :key="item.id" class="showFlight">
          <p>{{ item.airline }}</p>
          <p>{{ item.flightNumber }}</p>
          <p>{{ item.departure }}</p>
          <p>{{ item.arrival }}</p>
          <p>{{ item.date }}</p>
          <p>{{ item.time }}</p>
          <p>{{ item.price }} EUR</p>
          <button>Buy</button>
      </div>
      <div v-if="checkFlights">
        <h1>No flights found</h1>
      </div>
    </div>
    
  </div>
</template>