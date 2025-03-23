<script setup>
import { ref, onMounted } from 'vue'

const totalSeats = 36;

// generate random seats
const generateSeats = () => {
    return Array.from({ length: totalSeats }, (_, index) => ({
    id: index + 1,
    taken: Math.random() < 0.3,
    selected: false,
  }))
}

const seats1 = ref(generateSeats());
const seats2 = ref(generateSeats());


function selectSeat(seat) {
  if(!seat.taken){
    seat.selected = !seat.selected;
  }
}
</script>

<template>
  <button style="background-color: transparent; color:black; font-size: 25px;" @click="$router.push('/')">Back</button>
  <div class="container">
    <div class="seat-selection">
      <div class="seats-grid">
        <button
          :class="{ taken: seat.taken, empty: !seat.taken, selected: seat.selected }"
          v-for="seat in seats1"
          @click="selectSeat(seat)"
        ></button>
      </div>
      <div class="seats-grid">
        <button
          :class="{ taken: seat.taken, empty: !seat.taken, selected: seat.selected }"
          v-for="seat in seats2"
          @click="selectSeat(seat)"
        ></button>
      </div>
    </div>
    <div class="filter">
      <button style="background-color: red; "></button>
      <label>Koht on kinni</label>
      <br>
      <button style="background-color: green; margin-top: 10px;"></button>
      <label style="gap:20px;">Vaba Koht</label>
      <br>
      <button style="background-color:yellow; margin-top: 10px;"></button>
      <label>Valitud koht</label>
    </div>
  </div>
  <div class="buttonExplation">
  </div>
</template>

<style scoped>
.container {
  margin-top: 7%;
  padding: 25px;
  position: relative;
  flex: 1;
  display: flex;
  flex-direction: row;
  width: 256px;
  margin-left: auto;
  margin-right: auto;
  background-color: white;
  border: 2px solid black;
  border-radius: 10px;
}

.seat-selection {
  display: flex;
}

.seats-grid {
  display: grid;
  grid-template-columns: repeat(3, 20px);
  gap: 10px;
  margin-bottom: 20px;
  margin-right: 25px;
}

.taken {
  background-color: red;
}

.empty {
  background-color: #4caf50;
  color: white;
}

.selected{
  background-color: yellow;
}


button {
  padding: 10px;
  color: white;
  border: none;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
