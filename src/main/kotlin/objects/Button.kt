package com.yunhongmin.objects

class Button : Clickable, Focusable {
    override fun click() = println("Button2 clicked!")
    override fun setFocus() = println("Button2 Focused!")
    override fun showOff() = super<Clickable>.showOff()
}
