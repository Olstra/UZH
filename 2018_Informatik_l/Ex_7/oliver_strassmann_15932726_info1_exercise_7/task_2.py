# ========= Your classes ==========
"""
   Assignment 07, Informatik 1, UZH
   Oliver Strassmann
   Nov 2018
"""


import random


class Settings(object):
    """
    repeat:
    tells the class Spotify whether it should play the playlist
    on repeat.
    If yes, songs in pl.list will loop indefinitely.
    shuffle:
    tells class Spotify whether to shuffle playlist or not.
    If yes: songs in pl.list picked at random and continue playing indefinitely.
    """

    def __init__(self, shuffle, repeat):
        if type(shuffle) == bool and type(repeat) == bool:
            self.shuffle = shuffle
            self.repeat = repeat
        # TODO what if shuffle/repeat are not bool?


class Song(object):
    def __init__(self, title, artist, duration):
        self.title = title
        self.artist = artist
        self.duration = duration
        self.idx = None

    def __eq__(self, other):
        """
        checks for equality of 2 songs based on 'title', 'artist', 'duration'
        :return: True or False
        """
        return isinstance(other, Song) \
               and self.title == other.title \
               and self.artist == other.artist \
               and self.duration == other.duration

    def __str__(self):
        """
        :return: title - artist: duration [str, duration in s]
        """
        # output = ""
        # TODO if self.duration is not None and self.artist is not None and self.title is not None:
        output = "{} - {}: {}s".format(self.title, self.artist, self.duration)
        return output


class Playlist(object):

    def init_song_idx(self):
        for e in range(len(self._Playlist__songs)):
            self._Playlist__songs[e].idx = e

    def __init__(self, title, songs):
        self.__title = title
        self.__songs = songs
        self.init_song_idx()    # Initialize song indexes
        self.current_song = None

    def get_title(self):
        return self._Playlist__title

    def get_song_titles(self):
        titles = []
        for i in self._Playlist__songs:
            titles.append(i.title)
        return titles

    def load_song_by_title(self, title):
        for song in self._Playlist__songs:
            if song.title == title:
                return song
        print("What a strange taste in music, I could't find that song!")
        return None

    def load_next_song(self, shuffle, repeat):
        """
        :param shuffle: Boolean
        :param repeat: Boolean
        :return: the next song based on shuffle and repeat
        """

        if shuffle:
            return random.choice(self.get_song_titles())

        elif repeat:
            return self.current_song

        elif not shuffle and not repeat:
            if self.current_song is None:                       #if we are at beginning of playlist
                self.current_song = self._Playlist__songs[0]
            else:
                try:
                    next_i = self.current_song.idx + 1
                    self.current_song = self._Playlist__songs[next_i]
                except IndexError:                              # TODO test if this works
                    self.current_song = None

        return self.current_song



class Spotify(object):
    def __init__(self, playlist, settings):
        self.__playlist = playlist
        self.__settings = settings
        self.__current_song = None
        self.__is_playing = False

    def get_current_song(self):
        return self._Spotify__current_song

    def is_playing(self):
        if self._Spotify__current_song is None or self._Spotify__is_playing is False:
            return False
        return True

    def get_playlist_title(self):
        return self._Spotify__playlist.get_title()

    def play(self, title=""):

        # Playlist settings
        s1 = self._Spotify__settings.shuffle
        s2 = self._Spotify__settings.repeat

        # If song title was given
        if title != "":
            found_song = self._Spotify__playlist.load_song_by_title(title)

            if not found_song:
                print("Song title not found")
                self._Spotify__current_song = None
                self._Spotify__is_playing = False
                self._Spotify__playlist.current_song = None
                return
            else:
                self._Spotify__current_song = found_song
                self._Spotify__is_playing = True
                self._Spotify__playlist.current_song = found_song
                return

        # If no song was being played
        if self._Spotify__current_song is None:
            next_song = self._Spotify__playlist.load_next_song(s1, s2)

            if next_song is None:
                print("There was an error while loading next song")
                self._Spotify__is_playing = False
                # TODO set playlist.current song to None ???
            else:
                self._Spotify__current_song = next_song
                self._Spotify__is_playing = True
                self._Spotify__playlist.current_song = next_song
            return

        # if song is paused
        if not self._Spotify__is_playing:
            self._Spotify__is_playing = True
            return

        # If player is already playing do nothing
        if self._Spotify__is_playing:
            return

    def pause(self):
        self._Spotify__is_playing = False

    def next(self):
        s1 = self._Spotify__settings.shuffle
        s2 = self._Spotify__settings.repeat
        try:
            self._Spotify__is_playing = True
            next_song = self._Spotify__playlist.load_next_song(s1, s2)
            self._Spotify__current_song = next_song
            self._Spotify__playlist.current_song = next_song
            return
        except IndexError:
            print("Error, couldn't play next song")
            self._Spotify__is_playing = False
            self._Spotify__current_song = None
            self._Spotify__playlist.current_song = None
            return



# =================================

if __name__ == '__main__':
    no_repeat_no_shuffle = Settings(False, False)

    songs = [Song("Hotel California", "Eagles", 390),
             Song("Harder Better Faster Stronger", "Daft Punk", 224),
             Song("2112", "Rush", 1233)]
    playlist = Playlist("MyPlaylist", songs)

    player = Spotify(playlist, no_repeat_no_shuffle)

    player.play("Hotel California")

    assert player.get_playlist_title() == "MyPlaylist"

    assert playlist.get_song_titles() == ["Hotel California", "Harder Better Faster Stronger", "2112"]

    # assert playlist.load_next_song(False, False) == Song("Hotel California", "Eagles", 390)
    assert playlist.load_next_song(False, False) == Song("Harder Better Faster Stronger", "Daft Punk", 224)
    assert playlist.load_next_song(False, False) == Song("2112", "Rush", 1233)
    assert not playlist.load_next_song(False, False)

    assert playlist.load_song_by_title("2112") == Song("2112", "Rush", 1233)

    assert playlist.load_song_by_title("2112") == Song("2112", "Rush", 1233)

    # Reset playlist
    playlist = Playlist("MyPlaylist", songs)

    player = Spotify(playlist, no_repeat_no_shuffle)

    # Should be first song, playing
    player.play()
    assert player.get_current_song() == songs[0]
    assert player.is_playing()

    # Should not change song or playing
    player.play()
    assert player.get_current_song() == songs[0]
    assert player.is_playing()

    # Should not change song, playing is False
    player.pause()
    assert player.get_current_song() == songs[0]
    assert not player.is_playing()

    # Should not change song, playing back to True
    player.play()
    assert player.get_current_song() == songs[0]
    assert player.is_playing()

    # Should change song, playing True
    player.next()
    assert player.get_current_song() == songs[1]
    assert player.is_playing()

    # Should change song, playing True
    player.next()
    assert player.get_current_song() == songs[2]
    assert player.is_playing()

    # No songs left, song == None and playing False
    player.next()
    assert not player.get_current_song()
    assert not player.is_playing()

    # Load song by title
    player.play("2112")
    assert player.get_current_song() == songs[2]
    assert player.is_playing()

    # Previous song was last in playlist, next should return None, playing False
    player.next()
    assert not player.get_current_song()
    assert not player.is_playing()

    # Start playlist
    player.play()
    assert player.get_current_song() == songs[0]
    assert player.is_playing()

    player.next()
    player.next()
    player.next()
    assert not player.get_current_song()
    assert not player.is_playing()

    # When playlist is finished, calling next starts playlist again.
    player.next()
    assert player.get_current_song() == songs[0]
    assert player.is_playing()