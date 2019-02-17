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
        self.shuffle = shuffle
        self.repeat = repeat


class Song(object):
    def __init__(self, title, artist, duration):
        self.title = title
        self.artist = artist
        self.duration = duration

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
        # if self.duration is not None and self.artist is not None and self.title is not None:
        output = "{} - {}: {}s".format(self.title, self.artist, self.duration)
        return output


class Playlist(object):
    def __init__(self, title, songs):
        self.__title = title
        self.__songs = songs
        self.idx_current_s = 0

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
        return False

    def find_idx_of_title(self, title):
        songs = self.get_song_titles()
        if songs:
            for i in range(len(self._Playlist__songs)):
                if songs[i] == title:
                    return i
        return



    def find_index_of_song(self):
        songs = self.get_song_titles()
        if songs:
            for i in range(0, len(songs)):
                if songs[i] == self._Playlist__current_s.title:
                    return i

        print("Error - song seems no to be in playlist")
        return None

    # TODO what if shuffle and repeat???
    def load_next_song(self, shuffle, repeat):
        """
        :param shuffle: Boolean
        :param repeat: Boolean
        :return: the next song based on shuffle and repeat
        """

        if shuffle:
            return random.choice(self.get_song_titles())

        if repeat:
            i = self.idx_current_s
            if self._Playlist__songs[i]:
                return self._Playlist__songs[i]
            else:
                print("No song was currently playing.")
                return

        if not shuffle and not repeat:
            i = self.idx_current_s
            try:
                next = self._Playlist__songs[i]
                self.idx_current_s += 1
                return next
            except IndexError:
                print("Song was not found in playlist")
                return


class Spotify(object):
    def __init__(self, playlist, settings):
        self.__playlist = playlist
        self.__settings = settings
        self.__current_song = None
        self.__is_playing = False

    def set_idx_of_current_song(self):
        i = 0
        playlist = self._Spotify__playlist
        try:
            while self._Spotify__current_song != playlist._Playlist__songs[i]:
                i += 1
        except IndexError:
            print("Sorry, song not found!")
            return



    def get_current_song(self):
        if self._Spotify__current_song is not None:
            return self._Spotify__current_song
        return None

    def is_playing(self):
        if self._Spotify__current_song is None or self._Spotify__is_playing is False:
            return False
        return True

    def get_playlist_title(self):
        return self._Spotify__playlist.get_title()

    def play(self, title=""):

        # If player is already playing do nothing
        if self._Spotify__is_playing:
            return

        # If song title was given
        if title != "":
            found_song = self._Spotify__playlist.load_song_by_title(title)

            if not found_song:
                print("Song title not found")
                self._Spotify__current_song = None
                self._Spotify__is_playing = False
                self._Spotify__playlist.idx_current_s = 0   # TODO does this make sense???
                return
            else:
                self._Spotify__current_song = found_song
                self._Spotify__is_playing = True
                self._Spotify__playlist.idx_current_s = self._Spotify__playlist.find_idx_of_title(title)
                return

        # If no song was being played
        if self._Spotify__current_song is None:
            s1 = self._Spotify__settings.shuffle
            s2 = self._Spotify__settings.repeat

            self._Spotify__current_song = self._Spotify__playlist.load_next_song(s1, s2)
            self._Spotify__is_playing = True

            self._Spotify__playlist.idx_current_s += 1
            return

        # if song is paused
        if not self._Spotify__is_playing:
            self._Spotify__is_playing = True
            return

    def pause(self):
        self._Spotify__is_playing = False

    def next(self):
        s1 = self._Spotify__settings.shuffle
        s2 = self._Spotify__settings.repeat
        try:
            return self._Spotify__playlist.load_next_song(s1, s2)
        except IndexError:
            print("Error, couldn't play next song")
            self._Spotify__is_playing = False
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

    assert playlist.load_next_song(False, False) == Song("Hotel California", "Eagles", 390)
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

    # # Should change song, playing True
    # player.next()
    # assert player.get_current_song() == songs[2]
    # assert player.is_playing()

    # # No songs left, song == None and playing False
    # player.next()
    # assert not player.get_current_song()
    # assert not player.is_playing()

    # Load song by title
    player.play("2112")
    assert player.get_current_song() == songs[2]
    assert player.is_playing()

    # Previous song was last in playlist, next should return None, playing False
    # player.next()
    # assert not player.get_current_song()
    # assert not player.is_playing()

    # Start playlist
    # player.play()
    # assert player.get_current_song() == songs[0]
    # assert player.is_playing()

    # player.next()
    # player.next()
    # player.next()
    # assert not player.get_current_song()
    # assert not player.is_playing()

    # # When playlist is finished, calling next starts playlist again.
    # player.next()
    # assert player.get_current_song() == songs[0]
    # assert player.is_playing()

