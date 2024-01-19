import React from 'react'
import Constants from 'expo-constants'
import { View, Text, StyleSheet } from 'react-native'
import { useFetch } from '../api/UseFetch'

const EstanqueTable = ({ estanque }) => {
  const { data, error, loading } = useFetch(`http://${Constants.expoConfig.extra.hostApi}:8080/api/v1/especies/${estanque.idEspecie}`)

  return (
    <View style={styles.containerTableEstanque}>
      <View style={styles.rowContainer}>
        <View style={[styles.rowBorder, styles.colContanier]}>
          <Text style={styles.rowText}>Nivel Actual de Oxigeno</Text>
        </View>
        <View style={[styles.rowBorder, styles.colContanier]}>
          <Text style={styles.rowText}>Tipo de Estanque</Text>
        </View>
        <View style={[styles.rowBorder, styles.colContanier]}>
          <Text style={styles.rowText}>Especie de Pescado</Text>
        </View>
        <View style={styles.colContanier}>
          <Text style={styles.rowText}>Cantidad de Peces</Text>
        </View>
      </View>
      <View style={styles.rowContainer}>
        <View style={[styles.rowBorder, styles.colContanier]}>
          <Text style={styles.rowText}>24 Mg</Text>
        </View>
        <View style={[styles.rowBorder, styles.colContanier]}>
          <Text style={styles.rowText}>{estanque.tipoEstanque}</Text>
        </View>
        <View style={[styles.rowBorder, styles.colContanier]}>
          {error && <Text style={styles.rowText}>Error al cargar la especie</Text>}
          {loading && <Text style={styles.rowText}>Cargando...</Text>}
          <Text style={styles.rowText}>{data?.nombre}</Text>
        </View>
        <View style={styles.colContanier}>
          <Text style={styles.rowText}>{estanque.cantidadPeces}</Text>
        </View>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  containerTableEstanque: {
    width: '100%',
    borderWidth: 1,
    borderRadius: 5,
    justifyContent: 'space-between',
    flexDirection: 'row'
  },
  rowBorder: {
    borderBottomWidth: 1,
    borderRadius: 5
  },
  colContanier: {
    width: '95%',
    height: 45,
    justifyContent: 'center'
  },
  rowText: {
    fontSize: 15,
    textAlign: 'center'
  },
  rowContainer: {
    width: '50%',
    alignItems: 'center'
  }
})

export default EstanqueTable
