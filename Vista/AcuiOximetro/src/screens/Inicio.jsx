import React, { Suspense } from 'react'
import Constants from 'expo-constants'
import { View, ScrollView, Text, StyleSheet } from 'react-native'
import MenuUsuario from '../components/MenuUsuario.jsx'
import Estanques from '../components/Estanques.jsx'
import { fetchData } from '../api/FetchData.js'

const apiData = fetchData('http://localhost:8080/api/v1/estanques')

const Inicio = ({ navigation }) => {
  const data = apiData.read()

  return (
    <View style={[styles.header, styles.container]}>
      <MenuUsuario nombre='Angel' isAdmin navigation={navigation} />
      <ScrollView
        showsVerticalScrollIndicator={false}
        overScrollMode='never'
        contentContainerStyle={{ paddingBottom: 90 }}
      >
        <View style={styles.container}>
          <Text style={styles.title}>Estanques</Text>
          <View style={styles.containerEstanques}>
            <Suspense fallback={<Text>Cargando...</Text>}>
              {data?.map((estanque) => (
                <Estanques key={estanque.id} nombre={'Estanque ' + estanque.id} onPress={() => navigation.navigate('EstanqueDetalles', { estanque: 'ESTANQUE ' + estanque.id })} />
              ))}
            </Suspense>
          </View>
          <View />
        </View>
      </ScrollView>
    </View>
  )
}

const styles = StyleSheet.create({
  header: {
    paddingTop: Constants.statusBarHeight + 20
  },
  container: {
    flex: 1,
    backgroundColor: '#FFF',
    alignItems: 'center',
    justifyContent: 'center',
    gap: 20
  },
  title: {
    fontSize: 25
  },
  containerEstanques: {
    width: '85%',
    justifyContent: 'space-between',
    flexDirection: 'row',
    flexWrap: 'wrap',
    gap: 40
  }
})

export default Inicio
