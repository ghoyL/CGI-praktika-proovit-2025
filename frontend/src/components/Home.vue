<script setup>
import { ref, onMounted } from 'vue';

const departure = ref('');
const arrival = ref('');
const flights = ref([]);
const loading = ref(false);
const depratureDate = ref("");

// fetch flights data
async function flightData(allFlights, start, end) {
  try {
    let response;

    if (allFlights) {
      response = await fetch('http://localhost:8080/api/flights');
    }else if (depratureDate){
      response = await fetch(`http://localhost:8080/api/flights/search?departure=${start}&arrival=${end}&date=${depratureDate.value}`);
    } else {
      response = await fetch(`http://localhost:8080/api/flights/search?departure=${start}&arrival=${end}`)
    }
    if (!response.ok) {
      throw new error('Http fetchin error', error);
    }

    const data = await response.json();

    flights.value = data;
    loading.value = true;
  } catch (error) {
    console.log(error)
  }
}

onMounted(() => {
  flightData(true);
})

</script>

<template>
  <div class="container">
    <div class="searchFlights">
      <input class="yep" v-model="departure" placeholder="Alguspunkt" />
      <input class="yep" v-model="arrival" placeholder="Sihtpunkt" />
      <input type="date" id="datePicker" name="date" v-model="depratureDate"/>
      <button @click="flightData(false, departure, arrival)">Otsi</button>
      <button @click="flightData(true)">Näite kõiki lende</button>
    </div>
    <div class="flights">
      <div v-if="loading" v-for="item in flights" :key="item.id" class="showFlight">
        <p>{{ item.airline }}</p>
        <p>{{ item.flightNumber }}</p>
        <div class="time">
          <p>{{ item.departure }}</p>
          <p>{{ item.departureTime }}</p>
        </div>
        ------->
        <div class="time">
          <p>{{ item.arrival }}</p>
          <p>{{ item.arrivalTime }}</p>
        </div>
        <p>{{ item.date }}</p>
        <p>{{ item.price }} EUR</p>
        <button @click="$router.push('flightbooking')">Osta</button>
      </div>
    </div>
  </div>
</template>

<style scoped>

.yep{
  height: 20px;
}

input::placeholder {
  font-weight: bold;
  color: rgb(1, 1, 2);
}
.searchFlights {
  margin-top: 7%;
  position: relative;
  flex: 1;
  display: flex;
  flex-direction: row;
  max-width: fit-content;
  margin-left: auto;
  margin-right: auto;
}

.flights {
  margin-top: 50px;
}

.showFlight {
  display: flex;
  flex-direction: row;
  align-items: center;
  width: 100%;
  max-width: 730px;
  margin: 0 auto;
  gap: 25px;
  border: 2px black solid;
  border-radius: 10px;
  margin-bottom: 20px;
}

.container{
  width: 800px;
  position: relative;
  display: flex;
  flex-direction: column;
  margin-left: auto;
  margin-right: auto;
}

.showFlight{
  background-color: white;
}

</style>

<style>
body {
  background-image: url('tes.png'); 
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  position: fixed;
  width: 100%;
  height: 100%;
  z-index: -1; 
  background-attachment: fixed; 
}

</style>