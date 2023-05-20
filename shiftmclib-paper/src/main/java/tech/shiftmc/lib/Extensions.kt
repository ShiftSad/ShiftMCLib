package tech.shiftmc.lib

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver
import org.bukkit.entity.Player

fun String.asMini(tagResolver: TagResolver = TagResolver.empty()): Component = MiniMessage.miniMessage().deserialize(this, tagResolver)
fun Player.sendMiniMessage(message: String, tagResolver: TagResolver = TagResolver.empty()) = this.sendMessage(message.asMini(tagResolver))
fun Audience.sendMiniMessage(message: String, tagResolver: TagResolver = TagResolver.empty()) = this.sendMessage(message.asMini(tagResolver))