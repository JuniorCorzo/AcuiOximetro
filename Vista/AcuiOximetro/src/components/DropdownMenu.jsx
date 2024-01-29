/* eslint-disable react/jsx-indent */
import React, { useState } from 'react'
import { View, Text, StyleSheet, Pressable } from 'react-native'
import Icons from '@expo/vector-icons/FontAwesome'

const DropdownMenu = ({ title, data, onValueChange, onIdChange }) => {
  const [open, setOpen] = useState(false)
  const [rotate, setRotate] = useState(0)
  const [text, setText] = useState(title)

  const touch = () => {
    setRotate(rotate === 90 ? 0 : 90)
    setOpen(!open)
  }

  const changeTitle = (newTitle) => {
    setText(newTitle)
  }

  const renderOptions = () => {
    if (open) {
      return (
        <View style={{ gap: 10, alignItems: 'center' }}>
          {data?.map((item, index) => (text !== item
            ? <Pressable
                key={index + 1} onPress={() => {
                  changeTitle(item)
                  touch()
                  onValueChange(item)
                  onIdChange(index + 1)
                }} style={[styles.container, styles.containeOptions, styles.borderRadius]}
              >
              <Text style={styles.text}>{item}</Text>
              </Pressable>
            : null

          ))}
          <View />
        </View>
      )
    }
  }

  return (
    <View style={styles.main}>
      <View style={styles.borderRadius}>
        <View style={styles.container}>
          <Pressable style={styles.containerMenu} onPress={touch}>
            <Icons
              name='chevron-right'
              size={10}
              color='#000'
              style={{ transform: [{ rotate: `${rotate}deg` }] }}
            />
            <Text style={styles.text}>{text}</Text>
          </Pressable>
        </View>
        {renderOptions()}
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  main: {
    width: 320,
    gap: 10
  },
  container: {
    backgroundColor: '#FFF',
    height: 50,
    paddingVertical: 15,
    paddingHorizontal: 10
  },
  containerMenu: {
    alignItems: 'center',
    flexDirection: 'row',
    gap: 10
  },
  containeOptions: {
    width: 300
  },
  borderRadius: {
    borderWidth: 1,
    borderRadius: 5,
    overflow: 'hidden'
  },
  text: {
    textAlign: 'center',
    fontSize: 15
  }
})

export default DropdownMenu
